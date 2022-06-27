var ctx=document.getElementById("grafica1").getContext("2d");
var graf = new Chart(ctx,{
    type:"bar",
data: {
    labels:['Lunes','Martes', 'Miercoles','Jueves','Viernes','Sabado','Domingo'],
    datasets: [{
        label: 'entrada vehiculos de visitantes',
        data: [4, 6, 5, 8, 10, 15, 13],
        backgroundColor:['#623b5a', '#55d6be', '#cbef43', '#38A3A5', '#80ED99', '#2D46B9', '#297F87']
    }]
},
options: {
    scales: {
        yAxes: [{
            ticks: {
              beginAtZero: true
            }
        }]
    }
}
});



var ctx=document.getElementById("grafica2").getContext("2d");
var myLineChart = new Chart(ctx,{
    type: 'line',
    data:{
        labels:['Enero', 'Febrero', 'Marzo','Abril','Mayo','Junio'],
        datasets:[{
            label:'Correspondencia que llego',
            data:[70,50,80,60,85,90], 
            borderColor:['#FFC100', '#51E5FF', '#f76c5e','#55d6be','#2D46B9','#cbef43'],
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