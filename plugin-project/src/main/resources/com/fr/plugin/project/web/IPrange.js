;!(function () {
    var IP = BI.inherit(BI.Widget, {
        beforeInit: function (callback) { // get startIP and endIP
            var self=this;
            Dec.reqGet("/url/demo/ip/get","",function (res) {
                if(res.success){
                    self.startIP = res.data.startIP;
                    self.endIP = res.data.endIP;
                    callback();
                }
            })

        },
        render: function () {
            var self = this;

            function isValidIP(ip) {
                var reg = /^(\d{1,2}|1\d\d|2[0-4]\d|25[0-5])\.(\d{1,2}|1\d\d|2[0-4]\d|25[0-5])\.(\d{1,2}|1\d\d|2[0-4]\d|25[0-5])\.(\d{1,2}|1\d\d|2[0-4]\d|25[0-5])$/
                return reg.test(ip);
            }

                return {
                        type: "bi.vertical",
                        cls: "bi-card",
                        items: [
                            {
                                type: "dec.card.vertical",
                                hgap: 10,
                                text: BI.i18nText("Fine-Plugin_Dec_IP_Config"),
                                showButtons: true,
                                content: {
                                    type: "bi.vertical",
                                    vgap: 15,
                                    items: [{
                                        type: "bi.vertical_adapt",
                                        hgap:10,
                                        items: [{
                                            type: "bi.label",
                                            textAlign: "right",
                                            cls: "dec-font-weight-bold",
                                            text: BI.i18nText("Fine-Plugin_Dec_Start_IP"),
                                            title: BI.i18nText("Fine-Plugin_Dec_Start_IP"),
                                            width: 100
                                        }, {
                                            type: "bi.text_editor",
                                            textAlign: "left",
                                            cls: "bi-border",
                                            value:self.startIP,
                                            errorText: BI.i18nText("Fine-Plugin_Dec_IP_Check_Message"),
                                            lgap: 5,
                                            width: 300,
                                            validationChecker: function (v) {
                                                return isValidIP(v);
                                            },
                                            allowBlank: true,
                                            ref:function (_ref) {
                                                self.startIPWidget=_ref;
                                            }
                                        }]
                                    },
                                        {
                                            type: "bi.vertical_adapt",
                                            hgap:10,
                                            items: [{
                                                type: "bi.label",
                                                textAlign: "right",
                                                cls: "dec-font-weight-bold",
                                                text: BI.i18nText("Fine-Plugin_Dec_End_IP"),
                                                title: BI.i18nText("FIne-Plugin_Dec_End_IP"),
                                                width: 100
                                            }, {
                                                type: "bi.text_editor",
                                                textAlign: "left",
                                                cls: "bi-border",
                                                value:self.endIP,
                                                errorText: BI.i18nText("Fine-Plugin_Dec_IP_Check_Message"),
                                                lgap: 5,
                                                width: 300,
                                                validationChecker: function (v) {
                                                    return isValidIP(v);
                                                },
                                                allowBlank: true,
                                                ref:function (_ref) {
                                                    self.endIPWidget=_ref;
                                                }
                                            }]
                                        }]
                                },
                                listeners: [{
                                    eventName: "EVENT_CHANGE",
                                    action: function () {
                                        Dec.reqPost("/url/demo/ip/set",self.getValue(),function (res) {

                                        })
                                    }
                                }]
                            }
                        ]

                    };
        },
        getValue:function () {
            var self=this;
            return {
                startIP:self.startIPWidget.getValue(),
                endIP:self.endIPWidget.getValue()
            }
        }
    });
    BI.shortcut("dec.plugin.system.ip", IP);

    BI.config("dec.constant.system.tabs", function (items) {
        items.push({
            value: "ip config",
            text: BI.i18nText("Fine-Plugin_Dec_IP_Config"),
            cardType: "dec.plugin.system.ip"
        });
        return items;
    });
})();