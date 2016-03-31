<!DOCTYPE html>
<html>
<head>
  <#include "header.ftl">
  <script type="text/javascript" src="/library/js/jquery/jquery-1.9.1.min.js"></script>
</head>

<body>

  <#include "nav.ftl">

     <!-- Header -->
      <header class="intro-header" style="background-image: url('img/bg-sponsor.jpg')">
          <div class="container">
              <div class="row">
                  <div class="col-lg-8 col-lg-offset-2 col-md-10 col-md-offset-1">
                      <div class="page-heading">
                          <h1>About Wanderlust</h1>
                          <hr class="small">
                          <span class="subheading">This is what it about.</span>
                      </div>
                  </div>
              </div>
          </div>
      </header>
        <button id="get-info-btn">Contact</button>
        <ul id="my-info"></ul>
      <!-- Main Content -->
      <div class="container">
          <div class="row">
              <div class="col-lg-8 col-lg-offset-2 col-md-10 col-md-offset-1">
                   <#list paragraph as paragraph>
                   ${paragraph}
                   </#list>
                  <p>We assume that every person has wanderlust, when they been to somewhere, the experience and story is so unique and special and need to be shared.</p>
                  <p>Sharing the footprint of every journey you take and tell us the unique story and meaningful pic.</p>
                  <p>The coolest part is the story sharing part, because everyone is a story teller, sharing the unique story in the journey, let us/other people experience what you experience, love what you love.</p>
              </div>
          </div>
      </div>


  <footer>
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <ul class="list-inline">
                    <li>
                        <a href="index.html">Home</a>
                    </li>
                    <li class="footer-menu-divider">&sdot;</li>
                    <li>
                        <a href="discovery.html">Discovery</a>
                    </li>
                    <li class="footer-menu-divider">&sdot;</li>
                    <li>
                        <a href="stories.html">Stories</a>
                    </li>
                    <li class="footer-menu-divider">&sdot;</li>
                    <li>
                        <a href="about.html">About</a>
                    </li>
                </ul>
                <p class="copyright text-muted small">Copyright &copy; Wanderlust 2016. All Rights Reserved</p>
            </div>
        </div>
    </div>
  </footer>








    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
    <script src="js/bootstrap.min.js"></script>
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->

    <script src="../../assets/js/ie10-viewport-bug-workaround.js"></script>
    <script>

    function Aboutme() {
        var $btn = $("#get-info-btn");
        $btn.click(function(){
            $.get("/api/my_info", function( data ) {
          console.log(data);
          var dataJson = JSON.parse(data);
          var $container = $('#my-info')
          for (var key in dataJson) {
            var $li = $('<li>');
            $li.html(dataJson[key]);
            $container.append($li);
          }
           $btn.hide();

        });
        })
    }

    function advice() {
            var $container = $('#music-edit');
            var $btn = $container.find('button');
            var $input = $container.find('input');

            $btn.click(function(){
            $.post( "/api/add_music_info", { info: $input.val()})
              .done(function( data ) {
                data = JSON.parse(data);
                $('#music-info').append('<li><a>'+ data.info +'</a ></li>')
              });

            })
        }

      	Aboutme();
      	advice();

    </script>


  </body>


</html>