(ns om-unmount.core
  (:require [om.core :as om :include-macros true]
            [om.dom :as dom :include-macros true]))

(defn A [app]
  (reify
    om/IWillMount
    (will-mount [this]
      (prn "A will mount"))
    om/IWillUnmount
    (will-unmount [this]
      (prn "A will unmount"))
    om/IRender
    (render [_] (dom/div nil "A"))))

(defn B [app]
  (reify
    om/IWillMount
    (will-mount [this]
      (prn "B will mount"))
    om/IWillUnmount
    (will-unmount [this]
      (prn "B will unmount"))
    om/IRender
    (render [_] (dom/div nil "B"))))

(defn C [app owner]
  (reify
    om/IWillMount
    (will-mount [this]
      (js/setInterval #(om/update! app assoc :child (mod (.getTime (js/Date.)) 2)) 100))
    om/IRender
    (render [_]
      (om/build (if (= (:child app) 0) A B) app))))

(enable-console-print!)
(om/root {} C (.getElementById js/document "content"))
