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
    Array.prototype.forEach.call(results.rows, function(row) {
        if (row.rowIndex > 0) {
            dataTable.addRow([
                { v: (row.cells[0].textContent || row.cells[0].innerHTML).trim() },
                { v: 1 }
            ]);
        }
    });
    var responses = {
        title: "User's responses"
    };
    var dataSum = google.visualization.data.group(
        dataTable,
        [0],
        [{'column': 1, 'aggregation': google.visualization.data.sum, 'type': 'number'}]
    );
    var chart = new google.visualization.PieChart(document.getElementById('piechart'));
    chart.draw(dataSum, responses);
}