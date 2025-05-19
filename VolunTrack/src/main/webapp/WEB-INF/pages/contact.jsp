<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Contact Us</title>
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;500;600;700&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/contact.css">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+Devanagari:wght@400;500;600;700&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css" xintegrity="sha512-9usAa10IRO0HhonpyAIVpjrylPvoDwiPUiKdWk5t3PyolY1cOd4DSE0Ga+ri4AuTroPR5aQvXU9xC6qOPnzFeg==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <style>
      body {
        font-family: 'Poppins', sans-serif;
        font-family: 'Noto Sans Devanagari', sans-serif;
      }
      .contact-header h1{
        font-family: 'Noto Sans Devanagari', sans-serif;
      }
      .contact-header p{
        font-family: 'Poppins', sans-serif;
      }
      .contact-info .text h4{
        font-family: 'Noto Sans Devanagari', sans-serif;
      }
      .contact-form h3{
        font-family: 'Poppins', sans-serif;
      }
      .contact-form label{
        font-family: 'Poppins', sans-serif;
      }
      .contact-form input::placeholder,
      .contact-form textarea::placeholder{
        font-family: 'Poppins', sans-serif;
      }
      .contact-form button{
        font-family: 'Poppins', sans-serif;
      }
    </style>
</head>
<body>
    <div class="container">
        <div class="contact-header">
            <h1>Contact Us</h1>
            <p>We're always happy to hear from you! Please use the form below or contact us through our contact details.</p>
             <p style="font-size: 0.9rem; color: #4CAF50; font-weight: 500;"> Volunteering Website Management Team </p>
        </div>
        <div class="contact-content">
            <div class="contact-info">
                <div class="info-group">
                    <div class="icon">
                       <i class="fas fa-map-marker-alt"></i>
                    </div>
                    <div class="text">
                        <h4>Address</h4>
                        <p>काठमाडौं महानगरपालिका<br>वडा नं. ३२, नेपाल</p>
                    </div>
                </div>
                <div class="info-group">
                    <div class="icon">
                        <i class="fas fa-phone"></i>
                    </div>
                    <div class="text">
                        <h4>Phone</h4>
                        <p>०१-४२३४५६७, ९८४१२३४५६७</p>
                    </div>
                </div>
                <div class="info-group">
                    <div class="icon">
                       <i class="far fa-envelope"></i>
                    </div>
                    <div class="text">
                        <h4>Email</h4>
                        <p>info@example.com</p>
                    </div>
                </div>
            </div>
            <div class="contact-form">
                <h3>Send Message</h3>
                <form id="contactForm" action="contact" method="post">
                    <div class="form-group">
                        <label for="fullName">Full Name</label>
                        <input type="text" id="fullName" name="fullName" placeholder="Full Name" required>
                    </div>
                    <div class="form-group">
                        <label for="email">Email</label>
                        <input type="email" id="email" name="email" placeholder="Email" required>
                    </div>
                    <div class="form-group">
                        <label for="message">Your Message</label>
                        <textarea id="message" name="message" placeholder="Type your Message....." required></textarea>
                    </div>
                    <button type="submit">Send</button>
                </form>
            </div>
        </div>
    </div>
    <div id="messageSentModal" class="modal">
        <div class="modal-content">
            <span class="close">&times;</span>
            <p>Thank you for your message! We will get back to you shortly.</p>
        </div>
    </div>

<script>
    // Get the modal
    var modal = document.getElementById("messageSentModal");

    // Get the <span> element that closes the modal
    var span = document.getElementsByClassName("close")[0];

    // When the user clicks the button, open the modal
    $( "#contactForm" ).submit(function( event ) {
      event.preventDefault(); // Prevent the form from submitting in the default way
      modal.style.display = "block";

      // You can add your AJAX call here to send the form data to the server
      // $.ajax({
      //   type: "POST",
      //   url: "your-server-endpoint",
      //   data: $( this ).serialize(),
      //   success: function(response) {
      //     modal.style.display = "block";
      //     // Optionally, clear the form:
            $('#contactForm')[0].reset();
      //   },
      //   error: function() {
      //     alert("Sorry, there was an error sending your message. Please try again.");
      //   }
      // });
    });

    // When the user clicks on <span> (x), close the modal
    span.onclick = function() {
        modal.style.display = "none";
    }

    // When the user clicks anywhere outside of the modal, close it
    window.onclick = function(event) {
        if (event.target == modal) {
            modal.style.display = "none";
        }
    }
    $(document).ready(function(){
        $('#messageSentModal').css({
            'position': 'fixed',
            'top': '50%',
            'left': '50%',
            'transform': 'translate(-50%, -50%)'
        });
    });
</script>
</body>
</html>
