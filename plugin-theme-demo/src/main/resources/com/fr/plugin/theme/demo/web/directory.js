;!(function($){
    var Nav = BI.inherit(BI.Widget, {

        props: {
            baseCls: "dec-management-nav dec-popover",
            pinedPane: false
        },
        /**
         * set the model
         * @returns {*}
         * @private
         */
        _store: function () {
            return BI.Models.getModel("dec.model.modules");
        },
        /**
         * add listeners
         */
        watch: {
            selectedManageNav: function (v) {
                this.tree.setValue(v);
            },
            items: function () {
                this.populate(this.model.items);
            }
        },

        beforeInit: function (render) {
            this.store.initData(render);
        },

        render: function () {
            var self = this, o = this.options;
            return {
                // vertical layout
                type: "bi.vertical",
                hgap: 10,
                items: [
                    {
                        type: "bi.custom_tree",
                        cls: "dec-text",
                        ref: function (_ref) { //_ref refers to this sub-component
                            self.tree = _ref;
                        },
                        el: {
                            type: "bi.loader",
                            next: false,
                            el: {
                                type: "bi.button_tree",
                                chooseType: 0,
                                layouts: [{
                                    type: "bi.vertical",
                                    vgap: 5
                                }]
                            }
                        },
                        listeners: [{ // add a value change event to the tree. Open a tab when the event happens
                            eventName: "EVENT_CHANGE",
                            action: function () {
                                self.store.openTab(this.getValue()[0]);
                            }
                        }],
                        itemsCreator: function (op, callback) {
                            if (!op.node) {
                                self.store.initRootNodes(function (items) {
                                    callback(items);
                                });
                            } else {
                                self.store.getSubItemsByPId(op.node.id, op.node.layer + 1, function (items) {
                                    callback(items);
                                });
                            }
                        },
                        items: this._formatItems(this.model.items, 0)
                    }
                ]
            };
        },

        // parse the tree nodes recursively
        _formatItems: function (nodes, layer) {
            var self = this;
            BI.each(nodes, function (i, node) {
                var extend = {layer: layer};
                if (node.isParent === true || BI.isNotEmptyArray(node.children)) {
                    extend.type = "dec.nav.node";
                    BI.defaults(node, extend);
                    self._formatItems(node.children, layer + 1);
                } else {
                    extend.type = "dec.nav.item";
                    BI.defaults(node, extend);
                }
            });
            return nodes;
        },

        populate: function (nodes) {
            nodes = this._formatItems(nodes, 0);
            this.tree.populate(nodes);
        }
    });
    Nav.EVENT_VALUE_CHANGE = "EVENT_VALUE_CHANGE";
    BI.shortcut("my.theme.directory", Nav);

    BI.config("dec.workbench.panel", function (config) {
        config.type = "my.theme.directory";
        return config;
    });
})(jQuery);