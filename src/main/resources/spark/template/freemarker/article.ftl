<!DOCTYPE html>
    <html>
        <head>
        <#include "header.ftl">
        </head>

        <body>

        <#include "nav.ftl">

    <!-- Title -->
    <div class="form-group">
        <label for="title">Title: </label>
        <div>
            <input class="form-control" type="text" id="title" name='article-title' placeholder="Enter a new title" <#if article??>value="${article.getTitle()}"</#if> />
        </div>
    </div>


    <!-- Content -->
    <label for="content">Content</label>
    <textarea class="form-control" name='article-content' id="content" rows="10" cols="50" form="article-create-form" placeholder="Enter article content">
        <#if article??>
            ${article.getContent()}
        </#if>
    </textarea>

            <#if hasNoArticles??>
                <h3>${hasNoArticles}</h3>
            <#else>
                <#list articles as article>
                    <h4>${article.getTitle()}</h4>
                    <p>${article.getCreatedAt()}</p>
                    <p>${article.getContent()}</p>
                    <p>${article.getEditLink()} | ${article.getDeleteLink()}</p>
                    <hr>
                </#list>
            </#if>



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
