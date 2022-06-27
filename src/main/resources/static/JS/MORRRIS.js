new Morris.Line({
    element: 'grafico1',
    data:[
        {year:'2015',valor:30, valor1:30},
        {year:'2016',valor:20, valor1:40},
        {year:'2017',valor:10, valor1:40},
        {year:'2018',valor:10, valor1:50},
        {year:'2019',valor:40, valor1:60}
    ],
    xkey: 'year',
    ykeys: ['valor','valor1'],
    lineWidth: 1,
    labels: ['js','java'],
    resize: true,
    lineColors: ['#008B8B','purple']
});

//Gráfica en barras 
new Morris.Bar({
    element: 'grafico2',
    data:[
        {y:'Angular',a:80, b:90, c:50},
        {y:'Vue',    a:70, b:65, c:60},
        {y:'React', a:100, b:85, c:70},
        {y:'Svelte', a:60, b:55, c:70}
    ],
    xkey: 'y',
    ykeys: ['a','b','c'],
    labels: ['Colombia','Ecuador','Argentina'],
    resize: true,
    barColors: ['#4afde7','#b186f1','#f79ae5'],
    gridTextFamily:'comic sans'
});

// Gráfico Circular
Morris.Donut({
    element: 'grafico3',
    data:[
        {label:'Python',value:40 },
        {label:'Java',value:35},
        {label:'Php',value:20},
        {label:'.Net',value:20}
    ],
    resize: true,
    colors:['#4afde7','#b186f1','#f79ae5','purple']
});