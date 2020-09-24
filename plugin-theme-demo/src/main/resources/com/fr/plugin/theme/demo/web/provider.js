;!(function ($) {
    BI.$import(Dec.fineServletURL+"/file?path=/com/fr/plugin/theme/demo/web/theme.model.js");
    BI.$import(Dec.fineServletURL+"/file?path=/com/fr/plugin/theme/demo/web/list.js");
    BI.$import(Dec.fineServletURL+"/file?path=/com/fr/plugin/theme/demo/web/list.model.js");
    BI.$import(Dec.fineServletURL+"/file?path=/com/fr/plugin/theme/demo/web/button.js");
    BI.$import(Dec.fineServletURL+"/file?path=/com/fr/plugin/theme/demo/web/directory.js");
    BI.$import(Dec.fineServletURL+"/file?path=/com/fr/plugin/theme/demo/web/directory.model.js");

    var provider=BI.inherit(BI.Widget,{
        /**
         * return a data model used by this component
         * @returns {*}
         * @private
         */
        _store: function () {
            return BI.Models.getModel("dec.demo.theme.model");
        },
        beforeInit: function (callback) {
            this.store.initData(callback);
        },

        render:function () {
            return {
                type: "bi.absolute",
                items: [
                    {
                        el: {
                            /**
                             * The first element is also absolute layout. There are two children elements.
                             * dec.workbench.tabs the tabPane to show reports
                             * dec.workbench.panel the directory panel
                             */
                            type: "bi.absolute",
                            items: [
                                {
                                    el: {
                                        type: "dec.workbench.tabs"
                                    },
                                    top: 0, bottom: 0, right: 0,
                                    left: 240 // 240 is the same as the width of "dec.workbench.panel"
                                }, {
                                    el: {
                                        type: "dec.workbench.panel",
                                        width: 240
                                    },
                                    top: 0, bottom: 0,
                                    left: 0
                                }
                            ]
                        },
                        top: 80, left: 0, right: 0, bottom: 0 // set top to 80 because there are a header and a directory list above
                    }, {
                        /**
                         * use the default component
                         */
                        el: {
                            type: "dec.header"
                        },
                        height: 40,
                        top: 0, left: 0, right: 0
                    },{
                        /**
                         * this one is defined by ourselves
                         */
                        el:{
                            type:"dec.first.item.list",
                            height: 40,
                            layouts: [
                                {
                                    type: "bi.vertical_adapt"
                                }
                            ]
                        },
                        height:40,
                        top: 40, left: 0, right: 0
                    }
                ]
            }
        }
    });
    BI.shortcut("dec.demo.provider",provider);

    BI.config("dec.provider.layout", function (provider) {
        provider.setConfig({
            type: "dec.demo.provider"
        });
        return provider;
    });
})(jQuery);