<#include "security.ftl">
<#import "pager.ftl" as p>

<@p.pager url page />

<div class="card-columns">
    <#list page.content as message>
        <div class="card my-3">
            <#if message.filename??>
                <img src="/img/${message.filename}" class="card-img-top">
            </#if>
            <div class="m-2">
                <span>${message.text}</span>
                <i>${message.tag}</i>
            </div>
            <div class="card-footer text-muted">
                ${message.authorName}
            </div>
        </div>
    <#else>
        No message
    </#list>
</div>
<@p.pager url page />
</div>

