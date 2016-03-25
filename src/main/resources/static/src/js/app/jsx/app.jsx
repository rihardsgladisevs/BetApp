var React = require('react/addons');
var ReactDOM = require('react-dom');

var BetOption = React.createClass({
    render: function () {
        return (
            <tr>
                <td>{this.props.data.name}</td>
                <td>{this.props.data.odd.type}</td>
                <td>{this.props.data.odd.win}</td>
                <td>{this.props.data.odd.draw}</td>
                <td>{this.props.data.odd.lose}</td>
            </tr>
        );
    }
});

var BetOptionList = React.createClass({
    render: function () {
        var betOptionNodes = this.props.data.map(function (betOption) {
            return (
                <BetOption data={betOption} key={betOption.name}/>
            );
        });
        return (
            <div className="row">
                <table className="table-striped">
                    <tbody>
                    <tr>
                        <th>Name</th>
                        <th>Type</th>
                        <th>Win</th>
                        <th>Draw</th>
                        <th>Lose</th>
                    </tr>
                    {betOptionNodes}
                    </tbody>
                </table>
            </div>
        );
    }
});

var BetApp = React.createClass({
    getDataFromServer: function () {
        $.ajax({
            url: this.props.url,
            dataType: 'json',
            cache: false,
            success: function (data) {
                this.setState({data: data});
            }.bind(this),
            error: function (xhr, status, err) {
                console.error(this.props.url, status, err.toString());
            }.bind(this)
        });
    },
    refresh: function (betOption) {
        betOption = JSON.parse(betOption.body);
        var index = this.state.data.map(function (d) {
            return d.name;
        }).indexOf(betOption.name);
        if (index !== -1) {
            this.state.data[index] = betOption;
            /*this.setState(React.addons.update(this.state.data[index],
                {datetime: {$set: betOption.datetime}, odd: {$set: betOption.odd}}));*/
        } else {
            this.state.data.push(betOption);
        }
        this.setState({
            data: this.state.data
        });
    },
    getInitialState: function () {
        return {data: []};
    },
    componentDidMount: function () {
        this.getDataFromServer();
        var socket = new SockJS('/bet');
        var stompClient = Stomp.over(socket);
        var callback = this.refresh;
        stompClient.connect({}, function (frame) {
            console.log('Connected: ' + frame);
            stompClient.subscribe("/topic/updateBetOption", callback);
        });
    },
    render: function () {
        return (
            <div className="col-sm-12">
                <div className="row">
                    <div className="col-sm-12">
                        <h1>Bet options</h1>
                    </div>
                </div>
                <BetOptionList data={this.state.data}/>
            </div>
        );
    }
});

ReactDOM.render(
    <BetApp url="/rest/bets/"/>,
    document.getElementById('content')
);
