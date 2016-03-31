<!DOCTYPE html>
<html>
    <head>
        <title>${title}</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        </head>
    <body>
        <h3>${dayOfWeek}</h3>
            <#if dayOfWeek == "Monday">
                    <div class="notification">Monday</div>

            <#elseif dayOfWeek == "Tuesday">
                    <div class="notification">Tuesday</div>

            <#elseif dayOfWeek == "Wednesday">
                    <div class="notification">Wednesday</div>

            <#elseif dayOfWeek == "Thursday">
                    <div class="notification">Thursday</div>

            <#elseif dayOfWeek == "Friday">
                    <div class="notification">Friday</div>

            <#else>
                    <div class="notification">Weekend</div>

            </#if>
        </body>
    </html>