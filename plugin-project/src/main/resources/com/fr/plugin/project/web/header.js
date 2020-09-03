;!(function() {
    var extendAttr = BI.inherit(BI.Widget,{
        beforeInit: function (callback) {
            var self = this;
            Dec.reqGet("/url/demo/extend/attr","",function (res) {
                if(res.success){
                    self.address = res.data.address;
                    self.companyPhone = res.data.companyPhone;
                    self.companyEmail = res.data.companyEmail;
                    callback();
                }
            })

        },
        render:function () {
            var self = this;
            return {
                type: "bi.vertical_adapt",
                hgap:10,
                items:[{
                    type: "bi.text_button",
                    cls: "plugin-header-extend-attr",
                    text: BI.i18nText("Fine-Plugin_Dec_Address") + ": " + self.address,
                    handler: function () {
                        window.open(self.address)
                    }
                },{
                    type: "bi.label",
                    cls: "plugin-header-extend-attr",
                    text:BI.i18nText("Fine-Plugin_Dec_Phone")  + ": " + self.companyPhone
                },{
                    type: "bi.label",
                    cls: "plugin-header-extend-attr",
                    text: BI.i18nText("Fine-Plugin_Dec_Email") + ": " + self.companyEmail
                }]
            }

        }
    });
    BI.shortcut("dec.plugin.header.extend.attr",extendAttr);

    BI.config("dec.constant.header.items", function (items) {
        items.unshift({
            type: "dec.plugin.header.extend.attr"
        });
        return items;
    });
})();