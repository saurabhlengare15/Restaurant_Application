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

  $.get("http://localhost:8080/menu/getall", data => {
    var container = ``;
    for (let i = 0; i < data.length; i++) {
      container += `
            <div class="box">
            <div class="image">
            <img src="images/menu-1.jpg" alt="">
        </div>
        <div class="content">
            <div class="stars">
                <i class="fas fa-star"></i>
                <i class="fas fa-star"></i>
                <i class="fas fa-star"></i>
                <i class="fas fa-star"></i>
                <i class="fas fa-star-half-alt"></i>
            </div>
            <h3>${data[i].name}</h3>
            <p>${data[i].description}</p>
            <a href="edit.html?${data[i].id}" class="btn">Edit</a>
            <span class="price"><b>₹ ${data[i].price}</b></span>
        </div>
        </div>`;
    }
    $('.box-container').html(container);
  });

  $.get("http://localhost:8080/customer/getall", data => {
    var container = ``;
    for (let i = 0; i < data.length; i++) {
      container += `
                <div class="swiper-slide slide">
                    <i class="fas fa-quote-right"></i>
                    <div class="user">
                        <img src="images/pic-1.png" alt="">
                        <div class="user-info">
                            <h3>${data[i].name}</h3>
                            <div class="stars">
                            <p>${data[i].custid}</p>
                            </div>
                        </div>
                    </div>
                    <p>${data[i].email}</p>
                </div>`;
    }
    $('.cc').html(container);
  });

});

let menu = document.querySelector('#menu-bars');
let navbar = document.querySelector('.navbar');

let section = document.querySelectorAll('section');
let navLinks = document.querySelectorAll('header .navbar a');

var swiper = new Swiper(".review-slider", {
  spaceBetween: 40,
  centeredSlides: true,
  autoplay: {
    delay: 2000,
    disableOnInteraction: false,
  },
  loop: true,
  breakpoints: {
    0: {
      slidesPerView: 1,
    },
    540: {
      slidesPerView: 2,
    },
    668: {
      slidesPerView: 2,
    },
    1024: {
      slidesPerView: 3,
    },
  },
});