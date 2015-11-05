var CommentTable = React.createClass({
    render: function () {
        var rows = [];
        var parsedComments = JSON.parse(this.props.comments);

        for (var i = 0; i < parsedComments.length; i++) {
            var id = parsedComments[i].id;
            var comment = parsedComments[i];
            rows.push(<CommentTable.Row key={id} comment={comment} /* Comment without {} */ />);
        }

        return (
            <table>
                {/* child comment, put {} around */}
                <thead>
                <tr>
                    <th>Summary</th>
                    <th>Text</th>
                </tr>
                </thead>
                <tbody>{rows}</tbody>
            </table>
        );
    }
});

CommentTable.Row = React.createClass({
    render: function () {
        var name = this.props.comment.summary;
        return (
            <tr>
                <td>{name}</td>
                <td>{this.props.comment.text}</td>
            </tr>
        );
    }
});

ReactDOM.render(
    <CommentTable comments={COMMENTS}/>,
    document.getElementById('content')
);

// HighChart
$(function () {
    $('#chart').highcharts({
        chart: {
            type: 'bar'
        },
        title: {
            text: 'Fruit Consumption'
        },
        credits: {
            enabled: false
        },
        xAxis: {
            categories: ['Apples', 'Bananas', 'Oranges']
        },
        yAxis: {
            title: {
                text: 'Fruit eaten'
            }
        },
        series: [{
            name: 'Jane',
            data: [1, 0, 4]
        }, {
            name: 'John',
            data: [5, 7, 3]
        }]
    });
});