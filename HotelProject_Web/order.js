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
        //   document.querySelector('.loader-container').classList.add('fade-out');
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

    var url = window.location.href;
    var file = url.substring(url.lastIndexOf('?') + 1);
    console.log(file);

    if (window.localStorage.getItem('CustomerID') == null) {
        window.location.href = "./index.html";
    }

    $.get("http://localhost:8080/menu/get/" + file, data => {
        var container = ``;
        container += `
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
          <h3>${data.name}</h3>
          <p>${data.description}</p>
          <h1>Price: ₹ ${data.price}</h1>
        </div>`;
        $('.box').html(container);
    });

    document.getElementById("custid").placeholder = window.localStorage.getItem('CustomerID');

    $('#submit').click(() => {
        var url = window.location.href;
        var file = url.substring(url.lastIndexOf('?') + 1);

        var quantity = $('#quantity').val();
        console.log(quantity);

        if (quantity === '') {
            alert("Enter Quantity");
        } else {
            let new_req = {
                customers: {
                    custid: window.localStorage.getItem('CustomerID')
                },
                menu: {
                    id: file
                },
                qty: quantity
            }

            console.log(new_req);

            $.ajax({
                type: "POST",
                url: 'http://localhost:8080/order/save',
                data: JSON.stringify(new_req),
                dataType: 'application/json',
                contentType: 'application/json',
                success: function (data) {
                    console.log(data);
                }
            });
            alert("Data Inserted Successfully");
        }
    });

    $('#sub').click(() => {
        console.log("hello");
    })
    $('#hh').click(() => {
        console.log("hello");
    })

})