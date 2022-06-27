var ctx=document.getElementById("grafica3").getContext("2d");
var graf = new Chart(ctx,{
    type:"bar",
data: {
    labels:['Electricidad','acueducto', 'internet','todero'],
    datasets: [{
        label: 'Egresos Semanales(Miles)',
        data: [100, 250, 500, 333],
        backgroundColor:['#623b5a', '#55d6be', '#cbef43', '#38A3A5']
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





