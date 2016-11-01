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
    },
    snackBarLong: function(msg, action, longClick){

        exec(
            longClick, 
            statusCallback, 
            "SnackBarPlugin", 
            "snackBar",
            [{
                'msg':msg,
                'delay':"0",
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
