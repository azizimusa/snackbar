var exec = require('cordova/exec');

module.exports = {

    snackBarInfinite: function(msg, action){

        exec(
            clickCallback, 
            statusCallback, 
            "SnackBarPlugin", 
            "snackBar",
            [{
                'msg':msg,
                'delay':"-2",
                'action': action
            }]);
    }

};

function statusCallback(data){
        console.log("receive statusCallback : " + data);
    }

function clickCallback(data){
        console.log("receive clickCallback : " + data);
    }
