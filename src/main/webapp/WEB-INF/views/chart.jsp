<%@ page import="java.util.*" %>
<html>
  <head>
    <script type="text/javascript" src="https://www.google.com/jsapi"></script>
    <script type="text/javascript">
      google.load("visualization", "1", {packages:["corechart"]});
      google.setOnLoadCallback(drawVisualization);

      function drawVisualization() {
       // make sure your code inputs the right data here
	   // notice that we repeat the series, to draw also a line with the series bars.
	   //first line is for bar chart, second series is for line chart.
	   // the graphing chart takes it as two different series.
	   //  and graphs them separately, but since we oass the same data to both, they overlap.   
       
	    var data = new google.visualization.DataTable();
		// Slice-value columns.
		data.addColumn('string', 'Days');
		data.addColumn('number', 'Actual Effort Remaining');

		
		//var dataset = new Array("Environment=1", "Education=1", "Hospitality_Recreation=2", "Disaster_Accident=1", "Human Interest=3", "Labor=1");
		//var dataset = new Array();
		
		<%
		String str ="";
		Map<Integer,Integer> myMap = (Map<Integer,Integer>)  request.getAttribute("listOfProductBackLog");
		for (Map.Entry<Integer,Integer> entry : myMap.entrySet())
		{
		    str=str+'"'+entry.getKey() + "=" + entry.getValue()+'"'+',';
		}
		str = str.substring(0, str.length()-1);
		System.out.println("var dataset = new Array("+str+");");
		out.println("var dataset = new Array("+str+");");
		%>
		console.log(dataset);
		var mapSize = dataset.length;
		console.log(mapSize.toString());

		for (var i = 0; i < mapSize; i++) {                            // Iterate over key-value pairs
		var keyValuePair = dataset[i];                               // Get the i'th value.
		var keyValueArray = new String(keyValuePair).split("=");     // Split on '='
		data.addRow([keyValueArray[0], parseInt(keyValueArray[1])]); // Add record.
	}
	
    var options = {
      title : 'burndown chart',
      vAxis: {title: 'Hours Left'},
      hAxis: {title: 'Days'},
      seriesType: 'bars',
      series: {1: {type: 'line'}}
    };

    var chart = new google.visualization.ComboChart(document.getElementById('chart_div'));
    chart.draw(data, options);
  }
    </script>
  </head>
  <body>
    <div id="chart_div" style="width: 900px; height: 500px;"></div>
	<div id="info" align="center""> 
		BurnDownVelocity = ${burnDownVelocity} <br>
		EstimateProjectFinish = ${estimateProjectFinish} days
	
	</div>
  </body>
</html>