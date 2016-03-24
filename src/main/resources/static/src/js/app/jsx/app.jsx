var React = require('react');
var ReactDOM = require('react-dom');

var ReactApp = React.createClass({
    render: function () {
        return (
            <div className="app">
                Hello, world! I am a ReactApp.
            </div>
        );
    }
});
ReactDOM.render(
    <ReactApp />,
    document.getElementById('content')
);