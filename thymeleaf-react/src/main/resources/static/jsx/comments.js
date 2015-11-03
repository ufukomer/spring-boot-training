/*
 var paragraph = document.querySelector("#hello-message");
 paragraph.innerHTML = username;
 */

var CommentRow = React.createClass({
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

var CommentTable = React.createClass({
    render: function () {
        var rows = [];
        var parsedComments = JSON.parse(this.props.comments);

        for (var i = 0; i < parsedComments.length; i++) {
            var id = parsedComments[i].id;
            rows.push(<CommentRow comment={parsedComments[i]} key={id}/>);
        }

        return (
            <table>
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

ReactDOM.render(
    <CommentTable comments={COMMENTS}/>,
    document.getElementById('content')
);
