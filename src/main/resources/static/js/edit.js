// $(function(){
//     alert("yo");
//
//     $(".edit-button").on("click",function (){
//         console.log($(this).attr("data-id"));
//         window.location.replace(`/post/${$(this).attr("data-id")}/edit`);
//     });
//
//
// });

$(document).ready(function (){

    alert("yo");

    $(".edit-button").on("click",function (){
        console.log($(this).attr("data-id"));
        window.location.replace(`/post/${$(this).attr("data-id")}/edit`);
    });
});