/* Using google charting*/

google.charts.load('current', {
    packages: ['corechart'],
    callback: drawChart
});

function drawChart() {
    var dataTable = new google.visualization.DataTable({
        cols: [
            { label: 'Answer', type: 'string' },
            { label: 'Result', type: 'number' }
        ]
    });

    var results = document.getElementById('results');

    fetch("/responses")
            .then(res => res.json())
            .then(data => {
                console.log(data);
                for (var i = 0; i < data.length; i++)
                {
                    var val = data[i].response1;
                    var strRes;

                    if (val == 1)
                    {strRes = "Very easy"}
                    else if (val == 3)
                    {strRes = "Moderately difficult"}
                    else if (val == 5)
                    {strRes = "Very difficult"}
                    else
                    {strRes = "Default"}

                    var row = results.insertRow(-1);

                    row.insertCell(0).innerHTML = data[i].userId.username;
                    row.insertCell(1).innerHTML = strRes;
                    row.insertCell(2).innerHTML = data[i].comments;
                }
                afterGet(results, dataTable);
            })
}

function afterGet(results, dataTable)
{
    Array.prototype.forEach.call(results.rows, function(row) {
            if (row.rowIndex >= 0) {
                dataTable.addRow([
                    { v: (row.cells[1].textContent || row.cells[1].innerHTML).trim() },
                    { v: 1 }
                ]);
            }
        });
        var responses = {
            title: "Q: How difficult was the assigned task?",
            width: 700,
            height: 300,
            backgroundColor: '#e6e6e6',
            is3D: true
        };
        var dataSum = google.visualization.data.group(
            dataTable,
            [0],
            [{'column': 1, 'aggregation': google.visualization.data.sum, 'type': 'number'}]
        );
        var chart = new google.visualization.PieChart(document.getElementById('piechart'));
        chart.draw(dataSum, responses);
}