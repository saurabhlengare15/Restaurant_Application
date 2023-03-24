$(document).ready(() => {

    function loader() {
        //   document.querySelector('.loader-container').classList.add('fade-out');
    }

    function fadeOut() {
        setInterval(loader, 2500);
    }

    window.onload = fadeOut;


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

    var url = window.location.href;
    var file = url.substring(url.lastIndexOf('?') + 1);
    console.log(file);

    $.get("http://localhost:8080/menu/get/" + file, data => {
        var container = ``;
        container += `
          <img src="images/menu-1.jpg" alt="">`;
        $('.image').html(container);

        document.getElementById('name').value = `${data.name}`;
        document.getElementById('desc').value = `${data.description}`;
        document.getElementById('price').value = `${data.price}`;
    });

    $('#submit').click(() => {
        var url = window.location.href;
        var file = url.substring(url.lastIndexOf('?') + 1);

        var id = file;
        var name = $('#name').val();
        var desc = $('#desc').val();
        var price = $('#price').val();
        console.log(price);

        if (price === '' || desc === '' || name === '') {
            alert("Enter Details");
        } else {
            var data = {
                id: id,
                name: name,
                price: price,
                description: desc
            }

            console.log(data);

            $.ajax({
                type: "POST",
                url: 'http://localhost:8080/menu/save',
                data: JSON.stringify(data),
                dataType: 'application/json',
                contentType: 'application/json',
                success: function (data) {
                    console.log(data);
                }
            });
            alert("Data Updated Successfully");
        }
    });

})