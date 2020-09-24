;!(function ($) {
    var Model=BI.inherit(Fix.Model,{ // define a model inheriting Fix.Model
        state:function () { // define data of the model
            return {
                /**
                 * use this to store the selected directory id
                 */
                selectDirectory:""
            }
        },
        /**
         * use childContext to pass the model data to sub-components
         */
        childContext:["selectDirectory"],
        /**
         * define methods used by components
         */
        actions:{
            /**
             * initialize the selectDirectory
             * @param callback
             */
            initData:function (callback) {
                var self = this, o = this.options;
                /**
                 * use the provided method to get all directories under DecCst.DIRECTORY_TREE_ROOT_ID
                 * notice how we use selectDirectory here: model.xxx
                 * the usage in a component is the same
                 */
                Dec.Utils.getWorkbenchSubDirectoryById(DecCst.DIRECTORY_TREE_ROOT_ID, function (res) {
                    var result=res.data;
                    if(result&&result.length>0){
                        self.model.selectDirectory=result[0].id;
                    }
                    callback&&callback();
                })
            }
        }
    })
    /**
     * use BI.model to register it
     */
    BI.model("dec.demo.theme.model", Model);
})(jQuery);