$(document).ready(() => {

  var swiper = new Swiper(".home-slider", {
    spaceBetween: 30,
    centeredSlides: true,
    autoplay: {
      delay: 3000,
      disableOnInteraction: false,
    },
    pagination: {
      el: ".swiper-pagination",
      clickable: true,
    },
    loop: true,
  });

  var swiper = new Swiper(".review-slider", {
    spaceBetween: 20,
    centeredSlides: true,
    autoplay: {
      delay: 3000,
      disableOnInteraction: false,
    },
    loop: true,
    breakpoints: {
      0: {
        slidesPerView: 1,
      },
      640: {
        slidesPerView: 2,
      },
      768: {
        slidesPerView: 2,
      },
      1024: {
        slidesPerView: 3,
      },
    },
  });

  function loader() {
    document.querySelector('.loader-container').classList.add('fade-out');
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

  if (window.localStorage.getItem('CustomerID') == null) {
    window.location.href = "./login.html";
  }

  $('#submit').click(() => {

    var name = $('#name').val();
    var rev = $('#message').val();
    console.log(rev);

    var data = {
      name: name,
      message: rev
    }

    $.ajax({
      type: "POST",
      url: 'http://localhost:8080/review/save',
      data: JSON.stringify(data),
      dataType: 'application/json',
      contentType: 'application/json',
      success: function (msg) {
        console.log("Data Inserted Successfully...");
        // alert("Data Inserted Successfully.....");
      }
    });
  });

  var cid = window.localStorage.getItem('CustomerID');
  console.log(cid);

  $.get("http://localhost:8080/review/get/"+cid, data => {
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
                            </div>
                        </div>
                    </div>
                    <p>${data[i].message}</p>
                </div>`;
    }
    $('.cc').html(container);
  });

})