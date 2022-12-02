$(function(){
    alert("yo");

    $(".edit-button").on("click",function (){
        console.log($(this).attr("data-id"));
        window.location.replace(`/post/${$(this).attr("data-id")}/edit`);
    })

    $(".editButton").on('click', function(e){
        window.location.replace(`/posts/${$(this).attr("data-id")}/edit`);
    });
})