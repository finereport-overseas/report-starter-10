;!(function($){
    var Model = BI.inherit(Fix.Model, {
        _init: function () {
            this.platform = Dec.globleModel;
        },

        state: function () {
            return {
                modules: [],
                reports: []
            };
        },

        context: ["isPin","selectDirectory"],// inherit selectDirectory
        watch:{
            selectDirectory:function () { // set listener to selectDirectory. Reload directories when selectDirectory changes
                this.initReports();
            }
        },
        computed: {
            selectedManageNav: function () {
                return this.platform.selectedManageNav;
            },
            items: function () {
                var self = this;
                var constant = BI.Constants.getConstant("dec.constant.management.navigation");
                var results = [];

                results = BI.concat(results, this.model.reports);

                results.push({
                    id: "decision-management-root",
                    value: "decision-management-root",
                    isParent: true,
                    open: true,
                    cls: "setting-font",
                    text: BI.i18nText("Dec-Authority_PlatformModule")
                });

                BI.each(constant, function (index, item) {
                    var match = BI.find(self.model.modules, function (index, i) {
                        return item.id === i.id;
                    });
                    if (match) {
                        results.push(BI.extend({}, match, item));
                    }
                });


                BI.each(results, function (index, item) {
                    if (item.value === self.platform.selectedManageNav && (item.pId === "decision-management-maintenance")) {
                        BI.some(results, function (index, i) {
                            if (i.id === "decision-management-maintenance") {
                                i.open = true;
                                return true;
                            }
                        });
                    }
                    if (item.value === self.model.selectedManageNav) {
                        item.selected = true;
                    }
                    if (!item.pId) {
                        item.pId = "management";
                    }
                });
                BI.each(constant, function (index, item) {
                    if (item.dev) {
                        results.push(BI.extend({}, item));
                    }
                });
                return BI.Tree.transformToTreeFormat(results);
            }
        },
        actions: {
            /**
             * initialization
             * @param callback
             */
            initData: function (callback) {
                this.initDecisionModules();
                this.initReports(callback);
            },

            initDecisionModules: function () {
                var self = this;
                Dec.Plugin.getManagementModules(function (modules) {
                    self.model.modules = modules;
                });
            },
            /**
             * initial the directories
             * @param callback
             */
            initReports: function (callback) {
                var self = this;
                var parent=self.model.selectDirectory;
                if(BI.isEmptyString(parent)){
                    parent=DecCst.DIRECTORY_TREE_ROOT_ID;
                }
                Dec.Utils.getWorkbenchSubDirectoryById(parent, function (res) {
                    self.model.reports = self._formatReportItems(res.data);
                    callback&&callback();
                });
            },

            getSubItemsByPId: function (pId, layer, callback) {
                var self = this;
                Dec.Plugin.getEntriesByPid(pId, function (res) {
                    BI.some(self.model.reports, function (index, item) {
                        if (item.id === pId) {
                            item.open = true;
                            return true;
                        }
                    });
                    self.model.reports = self.model.reports.concat(self._formatReportItems(res.data));
                });
            },
            /**
             * the method to open a tab
             * @param tab
             */
            openTab: function (tab) {
                var module = BI.find(BI.Constants.getConstant("dec.constant.management.navigation"), function (index, item) {
                    return item.value === tab;
                });
                var report = BI.find(this.model.reports, function (index, item) {
                    return item.value === tab;
                });
                if (module) {
                    BI.Services.getService("dec.service.tabs").addItem(module);
                } else {
                    BI.Services.getService("dec.service.tabs").addItem(report);
                }
            }
        },

        _formatReportItems: function (nodes) {
            var self = this;
            var iconClsMap = BI.Constants.getConstant("dec.constant.look.icons.map");
            var temps = BI.deepClone(nodes);
            BI.each(temps, function (i, node) {
                var extend = {
                    value: node.id
                };
                var cls = iconClsMap[node.nodeIcon];
                if (cls) {
                    extend.iconCls = cls;
                } else {
                    extend.iconCls = node.isParent ? "dir-panel-folder-font" : "dir-panel-template-font";
                }
                BI.defaults(node, extend);
            });
            return temps;
        }
    });
    BI.model("dec.model.modules", Model);
})(jQuery);