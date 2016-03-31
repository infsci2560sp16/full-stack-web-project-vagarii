<html>
<head>
</head>
<body>
    <h1>The marvellous blog of mine</h1>
    <#list posts as post>
        <div class="post">
            <h2>${post.title}</h2>
            <p>${post.content}</p>

            <h3>Categories:</h3>
            <ul class="categories">
                <#list post.categories as category>
                    <li>${category}</li>
                </#list>
            </ul>
            <i>Published on the ${post.publishing_date}</i>
        </div>
    </#list>
</body>
</html>