$(document).ready(() => {
  if (window.localStorage.getItem('AdminID') == null) {
    $('#menu').hide();
    $('#order').hide();
    $('#logout').hide();
    $('#customer').hide();
    $('.logo').hide();
  } else {
    $('#login').hide();
  }
  $('.logo').click(() => {
    window.location.href = "home.html";
  })

  $('#customer').click(() => {
    window.location.href = "customer.html";
  })

  $('#login').click(() => {
    window.location.href = "index.html";
  })

  $('#menu').click(() => {
    window.location.href = "addmenu.html";
  })

  $('#order').click(() => {
    window.location.href = "addorder.html";
  })

  $('#logout').click(() => {
    window.localStorage.clear();
    window.location.href = "http://127.0.0.1:5500/Admin/index.html";
  });

  if (window.localStorage.getItem('AdminID') == null) {
    window.location.href = "./index.html";
  }

  $.get("http://localhost:8080/order/all", data => {
    var container = ``;
    var total = 0;
    const date = new Date();
    // var c = `${window.localStorage.getItem('CustomerID')}`;
    // $('#custid').append(`<p>${c}</p>`);
    for (let i = 0; i < data.length; i++) {
      total += data[i].amt;
      $("#pp").append(`<tr>
            <td>${data[i].ordid}</td>
            <td class="text-center">${data[i].orddate}</td>
            <td class="text-center">${data[i].customers.custid}</td>
            <td class="text-center">${data[i].menu.id}</td>
            <td class="text-center">${data[i].qty}</td>
            <td class="text-center">${data[i].amount}</td>
            </tr>`)
    }

    $("#date").append(` ${date}`);
  });

});




