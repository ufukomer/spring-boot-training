// JSX Transform with Babel: https://facebook.github.io/react/docs/tooling-integration.html

// Highcharts Component
var Chart = React.createClass({

    initializeChart: function() {
        var chartModel = this.props.chartModel;
        var seriesModel = this.props.seriesModel;
        var selector = this.myChart;

        var chartOptions = React.addons.update(chartModel, {
            chart: {
                renderTo: {$set: selector}
            },
            series: {$set: seriesModel}
        });

        var chartInstance = new Highcharts.Chart(chartOptions);
        this.setState({
            chartInstance: chartInstance
        });
    },

    render: function() {
        return (
            <div ref={(ref) => this.myChart = ref}></div>
        );
    },

    componentDidMount: function() {
        this.initializeChart();
    }

});

var seriesObject = [{
    name: 'Year 1800',
    data: [107, 31, 635, 203, 2]
}, {
    name: 'Year 1900',
    data: [133, 156, 947, 408, 6]
}, {
    name: 'Year 2008',
    data: [973, 914, 4054, 732, 34]
}];

var chartObject = {
    chart: {
        // It works without renderTo prop
        renderTo: 'container',
        type: 'bar'
    },
    title: {
        text: 'Historic World Population by Region'
    },
    subtitle: {
        text: 'Source: Wikipedia.org'
    },
    xAxis: {
        categories: ['Africa', 'America', 'Asia', 'Europe', 'Oceania'],
        title: {
            text: null
        }
    },
    yAxis: {
        min: 0,
        title: {
            text: 'Population (millions)',
            align: 'high'
        },
        labels: {
            overflow: 'justify'
        }
    },
    tooltip: {
        formatter: function() {
            return ''+
                this.series.name +': '+ this.y +' millions';
        }
    },
    plotOptions: {
        bar: {
            dataLabels: {
                enabled: true
            }
        }
    },
    legend: {
        layout: 'vertical',
        align: 'right',
        verticalAlign: 'top',
        x: -100,
        y: 100,
        floating: true,
        borderWidth: 1,
        backgroundColor: '#FFFFFF',
        shadow: true
    },
    credits: {
        enabled: false
    }
};

ReactDOM.render(
    <Chart
        seriesModel={seriesObject}
        chartModel={chartObject} />,
    document.getElementById('chartWithReact')
);