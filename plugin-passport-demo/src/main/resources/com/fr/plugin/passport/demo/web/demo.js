;!(function(){
    var WIDTH = 125;

    var demo = BI.inherit(BI.Widget, {

        props: {
            baseCls: "",
            configs: {} // the configured property, which is passed from outside
        },

        render: function () {
            var self = this, o = this.options;
            return {
                type: "bi.vertical",
                bgap: 15,
                items: [
                    {
                        type: "bi.vertical_adapt",
                        items: [
                            {
                                type: "bi.layout",
                                width: WIDTH
                            }, {
                                type: "bi.label",
                                textAlign: "left",
                                cls: "dec-font-weight-bold",
                                text: BI.i18nText("Fine-Plugin_Username_Suffix") + ":",
                                title: BI.i18nText("Fine-Plugin_Username_Suffix"),
                                width: 100
                            }, {
                                type: "bi.editor",
                                $value: "http-url",
                                ref: function (_ref) {
                                    self.suffix = _ref;
                                },
                                width: 400,
                                height: 24,
                                watermark: "",
                                value: o.configs.suffix // the suffix from the configuration
                            }
                        ]
                    }
                ]

            };
        },

        getValue: function () {
            return {
                suffix: this.suffix.getValue()
            };
        }
    });
    BI.shortcut("dec.user.setting.demo", demo);

    BI.config("dec.user.setting.authentications", function (items) {
        items.push({
            value: "demo",  // match the passport type
            text: BI.i18nText("Fine-Plugin_Passport_Name"),
            "@class": "com.fr.plugin.passport.demo.DemoPassportBean", // the whole path to the PassportBean class
            component: {
                type: "dec.user.setting.demo" // the custom component defined above
            }
        });
        return items;
    });
})();