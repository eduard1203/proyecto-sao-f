var ctx=document.getElementById("graf").getContext("2d");
var graf = new Chart(ctx,{
    type:"bar",
data: {
    labels:['Computador','Celular','Idpad'],
    datasets: [{
        label: 'Tipos de Productos',
        data: [60, 80, 70],
        backgroundColor:['#4afde7','#b186f1','#f79ae5']
    }]
},
options : {
    scales: {
        yAxes: [{
            ticks: {
                beginAtZero: true
            }
        }]
    }
}
});


//Gráfica Circular
var ctx=document.getElementById("graf1").getContext("2d");
var graf11 = new Chart(ctx,{
    type:"pie",
data : {
    labels: ['Mac','Lenovo','Dell'],
    datasets: [{
        label: 'Datos de Productos',
        data: [60, 100, 70],
        backgroundColor:['#4afde7','#b186f1','#f79ae5']
    }]
}
});

//Gráfico en Linea 
var ctx=document.getElementById("graf2").getContext("2d");
var graf2 = new Chart(ctx,{
    type: 'line',
    data: {
        labels:['MySQL','Oracle','MongoDB'],
        datasets:[{
            label:'Gestores de bases de datos',
            data:[60,80,70],
            borderColor:['#4afde7','#b186f1','#f79ae5'],
            pointBorderColor:['#4afde7','#b186f1','#f79ae5'],
            pointBorderWidth:8
        }]
    },
    options: {
        scales: {
            y: {
                stacked: true
            }
        }
    }
});