(ns {{ns-name}}.views
  (:use hiccup.core
        hiccup.page
        hiccup.element))







;- ----------------------------------------------------------------------------
;- 

(defn layout
  [& content]
  (html
    (doctype :html5)
    [:head 
      [:title "{{name}}"]
      [:meta {:http-equiv "Content-Type" :content "text/html; charset=UTF-8"}]
      (include-css "css/pure-min.css" 
                   "css/ionicons.min.css"
                   "css/app.css")
      "<!--[if lt IE 10]>"
      [:link {:href "css/ie.css" :rel "stylesheet" :type "text/css"}]
      "<![endif]-->"]
    [:body.body {} 
      content
      (include-js  
        "js/out/goog/base.js"
        "js/react-with-addons.min.js"
        "js/moment.min.js"
        "js/app.js")
      (javascript-tag "goog.require(\"{{sanitized}}.core\");")]))







;- ----------------------------------------------------------------------------
;- 

(defn index 
  [& content]
  (layout 
    [:div#app {} 
      [:div.loading {} "Loading {{name}}..."]]))



