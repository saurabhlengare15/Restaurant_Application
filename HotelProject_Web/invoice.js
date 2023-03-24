$(document).ready(() => {
    function loader() {
      // document.querySelector('.loader-container').classList.add('fade-out');
    }
  
    function fadeOut() {
      setInterval(loader, 2500);
    }
  
    window.onload = fadeOut;
  
  
    if (window.localStorage.getItem('CustomerID') == null) {
      $('#invoice').hide();
      $('#logout').hide();
    } else {
      $('#login').hide();
    }
  
    $('#home').click(() => {
      window.location.href = "index.html";
    })
  
    $('#login').click(() => {
      window.location.href = "login.html";
    })
  
    $('#invoice').click(() => {
      window.location.href = "invoice.html";
    })
  
    $('#logout').click(() => {
      window.localStorage.clear();
      window.location.href = "http://127.0.0.1:5500/index.html";
    })
  
    // if(window.localStorage.getItem('AdminID') == null){
    //   window.location.href = "./index.html";
    // }
  
    $.get("http://localhost:8080/order/get/"+window.localStorage.getItem('CustomerID'), data => {
        var container = ``;
        var total = 0;
        const date = new Date();
        var c = `${window.localStorage.getItem('CustomerID')}`;
        $('#custid').append(`<p>${c}</p>`);
        for (let i = 0; i < data.length; i++) {
            total += data[i].amount;
            $("#pp").append(`<tr>
            <td>${data[i].ordid}</td>
            <td class="text-center">${data[i].orddate}</td>
            <td class="text-center">${data[i].menu.id}</td>
            <td class="text-center">${data[i].qty}</td>
            <td class="text-center">${data[i].amount}</td>
            </tr>`)
        }

        $("#ff").append(`
        <tr>
            <th></th>
            <th></th>
            <th colspan="2" class="text-right">Total:</th>
            <th class="text-center">₹${total}</th>
        </tr>`);

        $("#date").append(` ${date}`);
    });
  
  })