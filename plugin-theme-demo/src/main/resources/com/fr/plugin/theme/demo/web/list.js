;!(function ($) {
    var firstList=BI.inherit(BI.Widget,{
        props:{
            height: 40,
            layouts: [
                {
                    type: "bi.center"
                }
            ]
        },
        /**
         * this component also use a model
         * @returns {*}
         * @private
         */
        _store: function () {
            return BI.Models.getModel("dec.first.item.list.model");
        },
        /**
         * call initData from the model
         */
        beforeInit: function (callback) {
            this.store.initData(callback);
        },
        /**
         * this is to observe the modified data defined in the corresponding model
         * e.g. items is defined in "dec.first.item.list.model". When the value of items changes, the function will be called
         * the parameter of the function is the changed value of items
         */
        watch:{
            "items":function (vals) {
                this.populate(vals);
            }
        },
        render:function () {
            var self = this, o = this.options;
            /**
             * create a new bi.button_group, which is provided by default
             * use the element property to mount the button group to this component
             * @type {*|*|*|*|*}
             */
            this.buttonGroup = BI.createWidget({
                element: this,
                type: "bi.button_group",
                /**
                 * here set the items for bi.button_group
                 */
                items: BI.createItems(self.model.items,{
                    type: "dec.first.items.button", // the component here is another custom one
                    height: o.height
                }),
                value: self.model.selectDirectory, // use the model's selectDirectory
                layouts: o.layouts
            });
            this.buttonGroup.on(BI.Controller.EVENT_CHANGE, function () {
                self.fireEvent(BI.Controller.EVENT_CHANGE, arguments);
            });
            /**
             * add a listener to observe the value change. When the selected button switches, the function will be called.
             * this function uses setSelectDirectory from the model to notify other components
             */
            this.buttonGroup.on(BI.ButtonGroup.EVENT_CHANGE, function (value, obj) {
                self.store.setSelectDirectory(value)
            });
        },
        /**
         * refresh the button group
         * @param items
         */
        populate: function (items) {
            var o = this.options;
            this.buttonGroup.populate(BI.createItems(items, {
                type: "dec.first.items.button",
                height: o.height
            }));
        }
    })
    BI.shortcut("dec.first.item.list",firstList)
})(jQuery);