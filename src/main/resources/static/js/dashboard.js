
/**
 * ***********************************************************************************************
 * dashboard js
 * ***********************************************************************************************
 */

$(function () {

    __quxianBaosongCharts();

    __baosongLeixingCharts();

    __tongzhiGonggao();

});

layui.use('element', function(){
    var element = layui.element;
});

function __quxianBaosongCharts() {
    var charts = echarts.init(document.getElementById('quxianBaosongCharts'));

    var county = ['那坡县', '靖西市', '大新县', '龙州县', '凭祥市', '宁明县', '东兴市', '防城区'];

    var chartData = [9865, 15579, 25761, 2767, 12076, 4166, 9207, 12383, 13749];

    var option = {
        tooltip: {
            trigger: 'axis',
        },
        grid: {
            left: '8%',
            top: '2%',
            right: '4.5%',
            bottom: '10%',
        },
        xAxis: {
            type: 'category',
            boundaryGap: false,
            data: county,
        },
        yAxis: {
            type: 'value'
        },
        series: [
            {
                smooth: true, // 平滑曲线
                data: chartData,
                type: 'line',
                areaStyle: {
                    normal : {
                        color:'#93cfeb', // 区域颜色
                    }
                },
                itemStyle : {
                    normal : {
                        color:'#275F82', // 折线点颜色
                        lineStyle:{
                            color:'#93cfeb' // 折线颜色
                        }
                    }
                },
            }
        ]
    };
    charts.setOption(option);
}

function __baosongLeixingCharts() {
    var charts = echarts.init(document.getElementById('baosongLeixingCharts'));

    var county = ['基础设施', '边境动态', '其他', '走私事件', '突发事件', '涉外事件'];

    var chartData = [4936, 5678, 4567, 3456, 6345, 7678];

    var newChartData = [];

    for (var i = 0; i < chartData.length; i++){
        newChartData.push({
            value: chartData[i],
            name: county[i],
        });
    }

    var option = {
        tooltip: {
            trigger: 'item',
            formatter: "{b}：{c}"
        },
        legend: {
            data: county,
            x: 'center',
            top: '90%', //距离顶部距离
            itemWidth: 8,
            itemHeight: 8,
        },
        color: ['#ca0814', '#df685b', '#e19362', '#edca67', '#80cd59', '#64a6e5'],
        series: [
            {
                // name: '漏斗图',
                type: 'funnel',
                width: '75%',
                left: '12.5%',
                right: '12.5%',
                top: '2%',
                bottom: '10%',
                label: {
                    show: true,
                    position: 'inside',
                    // formatter: '{b}预期: {c}',
                    formatter: '{c}',

                },
                labelLine: {
                    length: 10,
                    lineStyle: {
                        width: 1,
                        type: 'solid'
                    }
                },
                itemStyle: {
                    borderColor: '#fff',
                    borderWidth: 1,
                },
                emphasis: {
                    label: {
                        fontSize: 12,
                        position: 'inside',
                    },
                },
                data: newChartData
            }
        ]
    };
    charts.setOption(option);
}

function __tongzhiGonggao() {
    var element = $('#tongzhiGonggao');
    var data = [];
    for (var i = 0; i <= 10; i++){
        data.push({
            title: '中共桂林市委员会关于落实自治区党委第六巡视组扶贫领域机动式巡视反馈意见整改情',
            time: '2019-05-14',
        });
        if (i % 3 === 0){
            element.append('' +
                '<div class="d-flex justify-start bdb-1" style="padding: 11.35px 0;">' +
                '   <a href="#" data-link="hover" class="d-flex-item overflow-text">'+ data[i].title +'</a>' +
                '   <img class="mlr-sm" src="images/dashboard/icon-10.png">' +
                '   <span class="d-block c-gray">'+ data[i].time +'</span>' +
                '</div>' +
                '');
        } else {
            element.append('' +
                '<div class="d-flex justify-start bdb-1" style="padding: 11.35px 0;">' +
                '   <a href="#" data-link="hover" class="d-flex-item overflow-text">'+ data[i].title +'</a>' +
                '   <span class="d-block c-gray">'+ data[i].time +'</span>' +
                '</div>' +
                '');
        }
    }
}