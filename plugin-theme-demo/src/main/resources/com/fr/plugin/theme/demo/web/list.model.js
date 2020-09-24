;!(function ($) {
    var Model = BI.inherit(Fix.Model, {
        /**
         * @returns {{firstItems: Array}}
         */
        state: function () {
            return {
                firstItems: []
            }
        },
        /**
         * this context is to receive the field from the parent component
         * then this model can use selectDirectory directly
         *
         */
        context: ["selectDirectory"],
        /**
         * computed is similar to state
         * the property defined in state can be retrieved without a function
         * the property defined in computed should be return value of a function
         */
        computed: {
            /**
             * the items here modify the original firstItems
             * add a property to every item, and set the class of the item when its value equals selectDirectory
             *
             * @returns {*}
             */
            items: function () {
                var self=this;
                return BI.map(self.model.firstItems, function (index, item) {
                    var temp={value: item.id};
                    if(item.id==self.model.selectDirectory){
                        temp.cls="plugin-first-item-select";
                    }
                    return BI.extend(temp, item);
                });
            }
        },
        /**
         * define several methods
         */
        actions: {
            initData: function (callback) {
                var self = this, o = this.options;
                Dec.Utils.getWorkbenchSubDirectoryById(DecCst.DIRECTORY_TREE_ROOT_ID, function (res) {
                    self.model.firstItems=res.data;
                    callback&&callback();
                })
            },
            /**
             * to set the value of selectDirectory
             * @param v
             */
            setSelectDirectory:function (v) {
                this.model.selectDirectory=v;
            }
        }
    })
    BI.model("dec.first.item.list.model", Model);
})(jQuery);