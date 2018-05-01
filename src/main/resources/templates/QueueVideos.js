/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var list;
var videoid = "";
var startURL = "eiXwaP7zSRk?playlist=AW8OOp2undg";
var endURL = "&version;=3";

function getVideoID()
{
    var url = document.getElementById("videoURL");
    videoid = url.match(/(?:https?:\/{2})?(?:w{3}\.)?youtu(?:be)?\.(?:com|be)(?:\/watch\?v=|\/)([^\s&]+)/);
    if(videoid !== null) {
        addVideo(videoid);
    } else { 
    console.log("The youtube url is not valid.");
}
}

function addVideo(videoid)
{
    list = list.substring(0,list.length() - 11) + "," + videoid + endURL;   
}

function getVideos()
{
    if(list === null)
    {
        list = startURL + endURL;
    }
    return list;
}