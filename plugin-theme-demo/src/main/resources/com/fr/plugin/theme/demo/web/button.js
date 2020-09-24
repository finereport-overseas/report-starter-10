;!(function ($) {
    /**
     * the button inherits BI.BasicButton
     */
    var listButton = BI.inherit(BI.BasicButton, {

        props: {
            isShadowShowingOnSelected: true,
            once: true,
            readonly: true,
            height: 80,
            width: 80,
            cls:"plugin-first-item-unselect" // the class when it is unselected
        },
        render: function () {
            var self = this, o = this.options;
            /**
             * add a label to show text
             * @type {*|*|*|*|*}
             */
            this.text = BI.createWidget({
                type: "bi.label",
                cls:o.cls,
                element: this,
                text: o.text,
                height: o.height,
                width: o.width
            })
        },
        setText: function (v) {
            listButton.superclass.setSelected.apply(this, arguments);
        },
        setSelected: function (v) {
            listButton.superclass.setSelected.apply(this, arguments);
        }
    });
    BI.shortcut("dec.first.items.button",listButton)
})(jQuery);