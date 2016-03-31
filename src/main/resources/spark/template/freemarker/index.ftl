<!DOCTYPE html>
<html>
<head>
  <#include "header.ftl">
</head>

<body>

  <#include "nav.ftl">

  <a id="about"></a>
  <div class="intro-header">
      <div class="row">
          <div class="col-lg-12">
              <div class="intro-message">
                  <h1>Welcome</h1>
                  <div id="current-time"></div>


                          <h3>${dayOfTime}</h3>
                          <h3>${dayOfWeek}</h3>
                              <#if dayOfWeek == "Monday">
                                      <div class="notification">Tell us your story</div>

                              <#elseif dayOfWeek == "Tuesday,">
                                      <div class="notification">Tell us your story</div>

                              <#elseif dayOfWeek == "Wednesday">
                                      <div class="notification">Tell us your story</div>

                              <#elseif dayOfWeek == "Thursday">
                                      <div class="notification">Tell us your story</div>

                              <#elseif dayOfWeek == "Friday">
                                      <div class="notification">Tell us your story</div>

                              <#else>
                                      <div class="notification">Happy weekend!</div>

                              </#if>
                  <hr class="intro-divider">
                  <ul class="list-inline intro-social-buttons">
                      <li>
                          <a href="about.html" class="btn btn-default btn-lg"><i class="fa fa-twitter fa-fw"></i> <span class="network-name">Learn more</span></a>
                      </li>
                      <li>
                          <a href="signup.html" class="btn btn-default btn-lg"><i class="fa fa-github fa-fw"></i> <span class="network-name">Sign up now</span></a>
                      </li>
                      <!--<li>
                          <a href="#" class="btn btn-default btn-lg"><i class="fa fa-linkedin fa-fw"></i> <span class="network-name">Linkedin</span></a>-->
                  </ul>
              </div>
          </div>
      </div>

  </div>
  <!-- /.container -->
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

</body>
</html>
