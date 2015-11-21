define(function (require) {

    var React = require('react');

    var Hello = React.createClass({
        render: function () {
            return (
                <tr>
                    <th>Hello Dude!</th>
                </tr>
            )
        }
    });

    React.render(
        <Hello />,
        document.getElementById('react')
    );

});