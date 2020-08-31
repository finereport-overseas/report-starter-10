var Component = BI.inherit(BI.Widget, {
    props: {   // Common properties defined here
        element: null,
        disabled: false,
        invisible: false,
        invalid: false,
        baseCls: "",
        extraCls: "",
        cls:"",
        other:""
    },
    beforeInit: function (callback) {
        console.log("beforeInit");
        callback()
        // The method runs before the element initialize.
    },
    init: function () {
        console.log("init");
        // The initialization method
    },
    beforeCreate: function () {
        console.log("beforeCreate");
        // The method runs right before this component create its sub-components.
    },
    render: function () {
        console.log("render");
        // The method to create sub-components.
        return {
            type: "bi.label",// the type of the sub-component
            text: "FineUI Hello Word",
            othert:"other attr"
        };
    },
    created: function () {
        console.log("created");
        // The method runs after render()
    },
    beforeMount: function () {
        console.log("beforeMount");
        // The method runs before applying the sub-components to the front-end page.
    },
    mounted: function () {
        console.log("mounted");
        // The method runs after applying the sub-components to the front-end page.
    },
    beforeDestroy: function () {
        console.log("beforeDestroy");
        // The method runs before this component gets destroyed.
    },
    destroyed: function () {
        console.log("destroyed");
        // The method runs after this component gets destroyed.
    }
});
BI.shortcut("first.fineui.component", Component);

var FatherComponent = BI.inherit(BI.Widget, {
    props: {
    },
    beforeInit: function (callback) {
        console.log("FatherComponent beforeInit");
        callback()
    },
    init: function () {
        console.log("FatherComponent init");
    },
    beforeCreate: function () {
        console.log("FatherComponent beforeCreate");
    },
    render: function () {
        console.log("FatherComponent render");
        return {
            type: "first.fineui.component"// define the component above as the sub-component
        };
    },
    created: function () {
        console.log("FatherComponent created");
    },
    beforeMount: function () {
        console.log("FatherComponent beforeMount");

    },
    mounted: function () {
        console.log("FatherComponent mounted");

    },
    beforeDestroy: function () {
        console.log("FatherComponent beforeDestroy");

    },
    destroyed: function () {
        console.log("FatherComponent destroyed");
    }
});
BI.shortcut("first.fineui.component.father", FatherComponent);

BI.createWidget({
    type: "bi.absolute",// define a layout component
    element: "body",// mount this component under "body"
    items: [{
        el: {
            type: "first.fineui.component.father",// use the one we defined as the sub-component
            cls: "plugin-jscssinput-demo",
            width: 300,
            height: 40
        },
        left: 0,
        top: 0
    }]
});