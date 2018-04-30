var player;                   // You Tube player object
var theHistory = "";
var startTime = -1;


// When You Tube API is ready, create a new 
// You Tube player in the div with id 'player'
function onYouTubeIframeAPIReady() {
  player = new YT.Player('player_div', 
    {
        videoId: 'P5_GlAOCHyE',   // Load the initial video
        playerVars: {
               autoplay: 0,      // Don't autoplay the initial video
               rel: 0,           //  Don’t show related videos
               theme: "light",   // Use a light player instead of a dark one
               controls: 1,      // Show player controls
               showinfo: 0,      // Don’t show title or loader
               modestbranding: 1 // No You Tube logo on control bar
        },
        events: {               
               // Callback when onReady fires
               onReady: onReady,
            
               // Callback when onStateChange fires
               onStateChange: onStateChange,   

               // Callback when onError fires
               onError: onError
        }
    });

}

// Callback specified to process the onReady event has been received
// so can proceed with creating and managing You Tube player(s)
function onReady(event) {
  var time = getTime();
  theHistory = "player ready " + time + "<br/>" + theHistory;
  document.getElementById("history_div").innerHTML = theHistory;
  console.log("player ready");
  
  // make the interface visible since we're now ready to go
  document.getElementById('ux').style.visibility = 'visible';
    
}

function submitLoadVideoById() {
    var videoId = document.getElementById("loadVideoById").value;
    player.loadVideoById({videoId: videoId});
}
                         
function submitLoadVideoByURL() {
    var url = document.getElementById("loadVideoByUrl").value;
    player.loadVideoByUrl({mediaContentUrl: url});
}

function submitLoadPlaylist() {
    var playlistString = document.getElementById("loadPlaylist").value;
    var playlist = playlistString.split(',');
    player.loadPlaylist({playlist: playlist});
}

function submitCueVideoById() {
    var videoId = document.getElementById("cueVideoById").value;
    player.cueVideoById({videoId: videoId});
}
                         
function submitCueVideoByURL() {
    var url = document.getElementById("cueVideoByUrl").value;
    player.cueVideoByUrl({mediaContentUrl: url});
}

function submitCuePlaylist() {
    var playlistString = document.getElementById("cuePlaylist").value;
    var playlist = playlistString.split(',');
    player.cuePlaylist({playlist: playlist});
}

// Log state changes
function onStateChange(event) {
    var time = getTime();
    var state = "undefiend";
    switch (event.data) {
        case YT.PlayerState.UNSTARTED:
            state= "unstarted";
            break;
        case YT.PlayerState.ENDED:
            state = "ended";
            break;
        case YT.PlayerState.PLAYING:
            state = "playing";
            break;
        case YT.PlayerState.PAUSED:
            state = "paused";
            break;
        case YT.PlayerState.BUFFERING:
            state = "buffering";
            break;
        case YT.PlayerState.CUED:
            state = "video cued";
            break;
        default:
            state = "unknown (" + event.data + ")";
    }
            
    console.log('onStateChange: ' + state);
    theHistory = state + time + "<br/>" + theHistory;
    document.getElementById("history_div").innerHTML = theHistory;
}

// Log any errors
function onError(event) {
    var time =  getTime();
    var error = "undefined";
    switch (event.data) {
        case 2:
            error = "Invalid parameter value";
            break;
        case 5:
            error = "HTML 5 related error";
            break;
        case 100:
            error = "Video requested is not found";
            break;
        case 101:
            error = "Embedded playback forbidden by ownder";
            break;
        case 150:
            error = "Error processing video request";
            break;
        default:
            error = "unknown (" + event.data + ")";
    }
    console.log ("onError: " + error + time);
    theHistory = "<p class='error'>" + error + time +"</p>" + theHistory;
    document.getElementById("history_div").innerHTML = theHistory
}

function getTime() {
    var d = new Date();
    var currentTime = d.getTime();
    if (startTime == -1)
        startTime = currentTime;
    var elapsed = currentTime - startTime;
    var theTime = " (" + elapsed + " ms)";
    return theTime;
}


