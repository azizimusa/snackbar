function showSnackBarInfinite(msg, action, clickCallback){

    cordova.exec(
                clickCallback,
                statusCallback,
                "SnackBarPlugin", //Service Name
                "snackBar", // Action Name
                [{

                    'msg': msg,
                    'delay': "-2",
                    'action': action

                }]
            )

}

function showSnackBarLong(msg, action, clickCallback){

    cordova.exec(
                clickCallback,
                statusCallback,
                "SnackBarPlugin", //Service Name
                "snackBar", // Action Name
                [{

                    'msg': msg,
                    'delay': "0",
                    'action': action

                }]
            )

}

function showSnackBarShort(msg, action, clickCallback){

    cordova.exec(
                clickCallback,
                statusCallback,
                "SnackBarPlugin", //Service Name
                "snackBar", // Action Name
                [{

                    'msg': msg,
                    'delay': "1",
                    'action': action

                }]
            )

}

function statusCallback(data){
    console.log("Status : " + data);
}