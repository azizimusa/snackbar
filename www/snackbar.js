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

    statusCallback: function(data){
        console.log("receive statusCallback : " + data);
    },
    clickCallback: function(data){
        console.log("receive clickCallback : " + data);
    }

};
