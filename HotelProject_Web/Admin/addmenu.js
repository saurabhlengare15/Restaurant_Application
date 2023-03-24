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

  $('#submit').click(() => {

    var id = $('#id').val();
    var name = $('#name').val();
    var price = $('#price').val();
    var description = $('.description').val();

    var data = {
      id: id,
      name: name,
      price: price,
      description: description
    }

    $.ajax({
      type: "POST",
      url: 'http://localhost:8080/menu/save',
      data: JSON.stringify(data),
      dataType: 'application/json',
      contentType: 'application/json',
      success: function (msg) {
        console.log("Data Inserted Successfully...");
        // alert("Data Inserted Successfully.....");
      }
    });
  });

});

let menu = document.querySelector('#menu-bars');
let navbar = document.querySelector('.navbar');

menu.onclick = () => {
  menu.classList.toggle('fa-times');
  navbar.classList.toggle('active');
}
let section = document.querySelectorAll('section');
let navLinks = document.querySelectorAll('header .navbar a');

window.onscroll = () => {
  menu.classList.remove('fa-times');
  navbar.classList.remove('active');
  section.forEach(sec => {
    let top = window.scrollY;
    let height = sec.offsetHeight;
    let offset = sec.offsetTop - 150;
    let id = sec.getAttribute('id');

    if (top => offset && top < offset + height) {
      navLinks.forEach(links => {
        links.classList.remove('active');
        document.querySelector('header .navbar a[href*=' + id + ']').classList.add('active');
      });
    };
  });
}

document.querySelector('#search-icon').onclick = () => {
  document.querySelector('#search-form').classList.toggle('active');
}

document.querySelector('#close').onclick = () => {
  document.querySelector('#search-form').classList.remove('active');
}


function loader() {
  document.querySelector('.loader-container').classList.add('fade-out');
}

function fadeOut() {
  setInterval(loader, 2500);
}

window.onload = fadeOut;