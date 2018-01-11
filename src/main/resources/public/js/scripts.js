var ourRequest = new XMLHttpRequest();
var btn = document.getElementById('btn');
var amt = document.getElementById('amt');
var footer = document.getElementById('footer');
var fixer = document.getElementById('fixer');

btn.addEventListener('click', function() {
    amt.innerHTML = "";
    var toConvert = document.getElementById('ammountToConvert').value;
    var baseCurrency = document.getElementById('fromMoney').value;
    var foreignCurrency = document.getElementById('toMoney').value;
    ourRequest.open('GET', 'http://api.fixer.io/latest?base='+baseCurrency);

    if (toConvert == "") {
        amt.innerHTML = "Please enter a vaule";

    } else if (baseCurrency != foreignCurrency) {


        ourRequest.onload = function (){
        var ourData = JSON.parse(ourRequest.responseText);
        var dateAccess = ourData.date;
        var convertedAmount = toConvert * ourData.rates[foreignCurrency];
        amt.innerHTML = toConvert + "<span>" + baseCurrency + "</span>" + " is equal to " + convertedAmount.toFixed(2) + "<span>" + foreignCurrency + "</span>";
        footer.innerHTML = "Rates are as updated on " + dateAccess + "<span id='small'>  (YYYY/MM/DD) 4PM CET </span>";
        fixer.innerHTML = "Data is pulled from <a href='http://fixer.io/Fixer.io'>Fixer.io</a>"
        };

    }
    else {
        amt.innerHTML = "Please choose different curriencies";
    };
    ourRequest.send();
});
