;!(function () {
    /**
     * Extend FR.TextEditor.
     */
    FR.StyleTextEditor=FR.extend(FR.TextEditor,{
        /**
         * the initialization method
         * @private
         */
        _init: function () {
            FR.StyleTextEditor.superclass._init.apply(this, arguments);
        },
        /**
         * Get options passed from the back end.
         * Apply the font color to the element.
         * @returns {*|jQuery|HTMLElement}
         * @private
         */
        _createEditComp: function() {

            var o=this.options;

            return $("<input style='color:"+o.fontColor+"' type='text'/>");
        }
    });
    /**
     * Use shortcut to register the widget. The name should be unique and the same as the return value of Widget#getXType.
     */
    $.shortcut("styletext", FR.StyleTextEditor);
})();