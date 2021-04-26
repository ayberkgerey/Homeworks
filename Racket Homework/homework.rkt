#lang racket
; 191106206001 Ayberk GEREY
(define (sonuncuyusil mylist) ; 1
  (cond
    [(empty? (rest mylist)) empty]
    [(cons? mylist) (cons (first mylist) (sonuncuyusil (rest mylist)))]))

(sonuncuyusil (list 1 2 3 4 5))



(define (counter lst) ; 2 'Elim degmisken bütün hepsinin sayilarini bulmak istedim'
  (hash-map
   (foldl (lambda (e ht)
            (hash-update ht e add1 (lambda () 0)))
          (hash)
          lst)
   (lambda (k v) (list v k))))

(counter(list 1 5 1 8 1 7 1 5))



(for/product ((i 7))  2) ; 3




(define (prizmaHacim lst) ; 4
  (apply * lst))

(prizmaHacim (list 2 3 4))




(define (tersListe l) ; 5
  (let loop ((l l)
             (nl '()))
    (if (empty? l) nl             
        (loop (cdr l)           
              (cons (car l) nl)))))

(tersListe (list 1 2 3 4 5))